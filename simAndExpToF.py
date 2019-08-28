#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Aug 15 14:17:19 2019

@author: Emilio Moya

Purpose: Creates a plot of neutron time of flight, given data from both an experiment
and simulation. Also, certain thresholds and requirements can be set for the neutrons
that are plotted.

University of Michigan
"""

#Imports
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import normalize as nrm

#Imported Simulation Data
simData = pd.read_csv("Processed/neutronToF_All_pulses.o", delim_whitespace = True, header = None,
                           names = ["Cell", "Time", "PulseType", "History",
                                    "PulseHeight","EventType","ParticleNumber",
                                    "NumberofInteractions","Weight","Voxel",
                                    "IncidentEnergy"], nrows = 1e6)
#Imported Experiment Data
expData = pd.read_csv('exp1' ,
                       header = None, delim_whitespace = True, nrows = 1e7,
                           names = ['History' ,
                                    'Type' ,
                                    'Channel' ,
                                    'Time' ,
                                    'Energy'])

#Variables
minHeight = 0.1
minHeight2 = 0.5
minHeight3 = 1
bins = 100
xAxis = np.linspace(0, 2, bins)
neutrons = simData[simData.PulseType == 1]
start = 0.1
stop = 100

def dividedPlot(distribution, curve, Emax, start, stop):
    divData = []
    for index in range(len(distribution)):
        if curve[index] > 0:
            divData += [distribution[index] / curve[index]]
        else: divData += [0]
    return divData

#Stores neutron time of flight for simulation and experiment data
expTimes = expData[expData.Type == 1].Time
simTimes = neutrons[neutrons.PulseHeight > minHeight].Time
simTimes2 = neutrons[neutrons.PulseHeight > minHeight2].Time
simTimes3 = neutrons[neutrons.PulseHeight > minHeight3].Time

#Creates bins for simulation and experimental data
simBins = np.linspace(5, simTimes.max(), 101)
simBins2 = np.linspace(5,simTimes2.max(), 101)
simBins3 = np.linspace(5,simTimes3.max(), 101)
expBins = np.linspace(5, expTimes.max(), 101)

#Computes the histogram of the experiment and simulation data
[yExp, xExp] = np.histogram(expTimes, expBins)
[ySim, xSim] = np.histogram(simTimes, expBins)
[ySim2, xSim2] = np.histogram(simTimes2, expBins)
[ySim3, xSim3] = np.histogram(simTimes3, expBins)

#Normalizes the experiment and simulation data
normExp = nrm.normalizeCounts(yExp, xExp)
normSim = nrm.normalizeCounts(ySim, xSim)
normSim2 = nrm.normalizeCounts(ySim2, xSim2)
normSim3 = nrm.normalizeCounts(ySim3, xSim3)

#Finds the bins centers of the experiment and simulation bins
centersExp = nrm.edgesToCenters(expBins)
centersSim = nrm.edgesToCenters(expBins)
centersSim2 = nrm.edgesToCenters(expBins)
centersSim3 = nrm.edgesToCenters(expBins)
 
##Plots the normalized experiment and simulation data, with axises, a title, and a legend
#plt.plot(centersExp, normExp, alpha = 0.5, label = "Experiment")
#plt.plot(centersSim, normSim, alpha = 0.5, label = "Simulation 1 (Min Height = 0.1)")
#plt.plot(centersSim2, normSim2, alpha = 0.5, label = "Simulation 2 (Min Height = 0.5)")
#plt.plot(centersSim3, normSim3, alpha = 0.5, label = "Simulation 3 (Min Height = 1)")
#plt.xlabel("Time (ns)")
#plt.ylabel("Normalized Counts")
#plt.title("Neutron Time of Flight of Expiriment and Simulation")
#plt.legend()
#plt.yscale("log")

##Plots the normalized experiment and simulation data divded by each other, with axises, a title, and a legend
#divPlot = dividedPlot(normSim, normExp, simTimes.max(), start, stop)
#divPlot2 = dividedPlot(normSim2, normExp, simTimes2.max(), start, stop)
#divPlot3 = dividedPlot(normSim3, normExp, simTimes3.max(), start, stop)
#plt.plot(centersExp, divPlot, label = "Min Height = 0.1 MeVee")
#plt.plot(centersExp, divPlot2, label = "Min Height = 0.5 MeVee")
#plt.plot(centersExp, divPlot3, label = "Min Height = 1 MeVee")
#plt.xlabel("Time (ns)")
#plt.ylabel("Normalized Counts")
#plt.title("Neutron Time of Flight of Simulation Divided by Experiment")
#plt.yscale("log")
#plt.legend()

#Finds the cumulative sum of the square of all neutron energies from the simulation divided by the experiment data
diffData = normSim - normExp
squareData = diffData ** 2
cumulativeData = sum(squareData)