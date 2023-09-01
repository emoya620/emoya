#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Jul 12 14:02:32 2019

@author: Emilio Moya

University of Michigan
"""

#Imports
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

#Variables
meC = 0.511 #MeV
mnC = 939 #MeV
mpC = 938 #MeV
distance = 100 #cm
speed = 30 #30cm/1ns
bins = 1000
xAxis = np.linspace(0.1, 10, bins)
start = 0.1
stop = 100
E = []

#Finds the energy of a praticle given its time of flight
def findEnergy(time):
    E = (.5 * mnC) * (((distance / time) / speed) ** 2)
    y = E
    return y

#Creates the efficiency curve given a max and minimum energy, max efficiency, energy domain, and x-value
def efficiencyCurve(eMin, eMax, effMax, x):
    slope = (0 - effMax) / (eMax - eMin)
    b = 0 - (slope * eMax)

    if x < eMin:
        eff = 0
    else:
        y = slope * x + b
        eff = y
    return eff

#Creates a histogram of the energy curve divided by the efficiency curve, given both curves, 
#a maximum energy, and a stop and start point
def dividedHist(distribution, curve, Emax, start, stop):
    divData = []
    for index in range(len(distribution)):
        if curve[index] > 0:
            divData += [distribution[index] / curve[index]]
        else: divData += [0]
    return divData

#Imports neutron and photon data
data = pd.read_csv('neutronToF/expfiles/exp1' ,
                   nrows = 1e6, header = None, delim_whitespace = True,
                       names = ['History' , 
                                'Type' ,
                                'Channel' ,
                                'Time' ,
                                'Energy'])

#Assigns the x and y data for the energy curve
x = data[data.Type == 1].Energy
y = data[data.Type == 1].Time
    

[eCounts, eBins] = np.histogram(data[data.Type == 1].Energy, xAxis)
centers = (eBins[:-1] + eBins[1:]) /2

#Plots the energy curve as a histogram
plt.hist(x, xAxis, alpha = 0.5, label = "Energy Equation")

indexMax = np.argmax(eCounts)
minE = centers[indexMax]
maxE = 11
height = max(eCounts)

#Graphs the efficiency curve
effData = []
for x in centers:
    effData += [efficiencyCurve(minE, maxE, height, x)]
plt.plot(centers, effData)
plt.title("Energy Curve of Neutrons")
plt.xlabel("Energy of Neutrons (MeV)")
plt.ylabel("Counts of Neutrons")
plt.rcParams.update({'font.size': 16})
plt.show()

xData = []
for x in range(len(centers)):
    if len(xData) + 1 < 1000:
        xData += [centers[x]]

eCounts = np.array(eCounts)
effData = np.array(effData)

ratio = eCounts/effData
ratio[np.isnan(ratio)] = 0
ratio[np.isinf(ratio)] = 0

#Graph of the curve divided by the triangle
divGraph = dividedHist(eCounts, effData, maxE, start, stop)
plt.plot(centers, ratio)
plt.title("Energy Curve Divided by Efficiency")
plt.xlabel("Energy of Neutrons (MeV)")
plt.ylabel("Counts/Efficiency")
plt.rcParams.update({'font.size': 16})
plt.show()
    
#x = [data.Time.apply(findEnergy)]    

#plt.hist(data[data.Type == 1].Energy, np.linspace(0, 15, 200), alpha = 0.5)
#plt.xlabel("Energy of Neutron (MeV)")
#plt.ylabel("Number of Neutrons")
#plt.title("Energy Curve of Neutrons")
#plt.show()


    
#plt.hist(data[data.Type == 1].Time, np.linspace(0, 100, 100))
#plt.hist(data[data.Type == 2].Time, np.linspace(0, 100, 100))
#plt.xlabel("Time (ns)")
#plt.ylabel("")
#plt.title("")
#plt.show()
#
#plt.hist(data[data.Type == 1].Energy, np.linspace(0, 25, 100), alpha = 0.5)
#plt.hist(data[data.Type == 2].Energy, np.linspace(0, 25, 100), alpha = 0.5)
#plt.xlabel("Time (ns)")
#plt.ylabel("")
#plt.title("")
#plt.show()
#

n_ToF = np.histogram(data[data.Type == 1].Energy, xAxis)
