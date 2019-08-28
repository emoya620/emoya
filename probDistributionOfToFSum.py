#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jul 24 10:55:27 2019

@author: Emilio Moya

University of Michigan
"""

#Imports
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import normalize as nrm
#import dnngVisualizationConstant as dnng

#Variables
numBins = 1000
xAxis = np.linspace(0, 10, numBins + 1 )
NPS = 10000

# Creates a cumulative distribution function given a probability and bin edges
def makeCDF(probability, edges):
    probability = nrm.normalizeCounts(probability, edges)
    widths = (edges[1:] - edges[:-1])
    widths = np.array(widths)
    # Compute the CDF
    CY = np.cumsum(probability * widths)
    return CY

# Finds a random numbers given  a probability, edges, and a max number, then computes a CDF of those points
def findRandom(probability, edges, maxNum):
    index = 0
    isSmaller = True
    centers = (edges[:-1] + edges[1:]) /2
    CY = makeCDF(probability, edges)
    while isSmaller:
        isSmaller = (maxNum > (CY[index]))
        index += 1
        
    return centers[index - 1]

# Plots a PDF of ToF given neutron and photon data
def plotSim():
    #Creates a data frame that we pull data from in order to create a histogram
    data = pd.read_csv('neutronToF/expfiles/exp1' ,
                       nrows = 1e6, header = None, delim_whitespace = True,
                           names = ['History' , 
                                    'Type' ,
                                    'Channel' ,
                                    'Time' ,
                                    'Energy'])
    
    #Stores all energy values in x, and all time values in y for our data
    
    energyNeutrons = np.array(data[data.Type == 1].Energy)
    [neutronSpectrum, neutronEdges] = np.histogram(energyNeutrons, xAxis)
    neutronCenters = (neutronEdges[:-1] + neutronEdges[1:]) /2
    #y = data[data.Type == 1].Time
    
    
    #Creates the histogram, labels it, changes the font size, and plots it
    fig = plt.figure()
#    plt.hist(energyNeutrons, xAxis, alpha = 0.5, label = "Energy Equation")
#    plt.title("Energy Curve of Neutrons")
#    plt.xlabel("Energy of Neutrons (MeV)")
#    plt.ylabel("Counts of Neutrons")
#    plt.rcParams.update({'font.size': 16})
#    
#    plt.plot(neutronCenters, neutronSpectrum)
#    plt.show()
    
#    cdfNeutrons = makeCDF(neutronSpectrum, xAxis)
    
#    plt.plot(neutronCenters, cdfNeutrons)
#    plt.show()
    fig.savefig('Figures')
    
    energySum = []
    arrayEnergy1 = []
    arrayEnergy2 = []
    for neutron in range(NPS):
        neutron1 = np.random.rand()
        neutron2 = np.random.rand()
        energy1 = findRandom(neutronSpectrum, neutronEdges, neutron1)
        energy2 = findRandom(neutronSpectrum, neutronEdges, neutron2)
        arrayEnergy1 += [energy1]
        arrayEnergy2 += [energy2]
        energySum += [energy2 + energy1]
        varianceSum = np.var(arrayEnergy1) + np.var(arrayEnergy2)
    
    print("Energy1 and Energy2 Variance Sum: " + str(varianceSum)) 
    print("Experiment Variance: " + str(np.var(energySum)))
        
    [neutronEnergySum, simBins] = np.histogram(energySum, np.linspace(0, 25, 100))
    return [neutronEnergySum, simBins]