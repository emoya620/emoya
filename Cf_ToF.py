#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Aug  5 10:45:25 2019

@author: Emilio Moya

Purpose: Creates a plot of the Time of Flight of neutrons and photons given data,
taken from a Cf-252 source.
    
University of Michigan
"""

#Imports
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
#import dnngVisualizationConstant as dnng
    
#Creates a data frame that we pull data from in order to create a histogram
data = pd.read_csv('neutronToF/expfiles/TOF_Data - Cf-252.tsv' ,
                   nrows = 1e5, header = None, delim_whitespace = True,
                       names = ['Edges' , 
                                'Counts'])

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
    return divData

def avgEnergy(energy, prob):
    energies = []
    for x in range(len(energy)):
        energies += [energy[x] * prob[x]]
    totEnergy = sum(energies)
    average = totEnergy
    return average

#Variables
minEdge = 275
maxEdge = 400
bins = 40
meC = 0.511 #MeV
mnC = 939 #MeV
mpC = 938 #MeV
distance = 100
speed = 30
bins = 100
#xMin = 0
#xMax = 150
start = 0.1
stop = 100
E = []
xAxis = np.linspace(0, 100, bins)
data['energyEdges'] = 5216/(data['Edges'] ** 2)
probability = []

#Turns the edges data column into an array of strings
edges = np.array(data.Edges)

#Creates an array of ints for both the counts and edges data
counts = np.array(data.Counts)
edges = np.array(edges)

#Creates an array of edges and counts in a specific range on the x-axis
selectCounts = []
selectEdges = []
for x in range(minEdge, maxEdge):
    selectEdges += [data.loc[x].energyEdges]
    selectCounts += [data.loc[x].Counts]
    
#Converts data to arrays    
selectCounts = np.array(selectCounts)
selectEdges = np.array(selectEdges)    

#Stores the energy average and total counts of neutrons
neutronEnergyMean = selectEdges.mean()
totCounts = selectCounts.sum()
    
#Finds the probability of neutrons at a specific time on the plot
for x in range(len(selectCounts)):
    probability +=  [selectCounts[x]/ totCounts]

#Stores the energy values of neutrons given time
energy = []
for x in range(len(selectEdges)):
    if selectEdges[x] != 0:
        energy += [findEnergy(selectEdges[x])]
    
#Finds the counts and bins(centers) given the energy data and an x-axis
[eCounts, eBins] = np.histogram(energy, xAxis)
centers = (eBins[:-1] + eBins[1:]) / 2

#Variable for the efficiency curve
indexMax = np.argmax(eCounts)
minE = centers[indexMax]
maxE = 11
height = max(eCounts)

#Graphs the efficiency curve of the data
effData = []
for x in centers:
    effData += [efficiencyCurve(minE, maxE, height, x)]
plt.plot(edges, counts)
plt.title("Efficiency Curve of Neutrons")
plt.xlabel("Energy of Neutrons (MeV)")
plt.ylabel("Counts of Neutrons")
plt.rcParams.update({'font.size': 16})
plt.show()

##Creates a plot of the time of flight of neutrons and photons, given edges and counts.
#plt.hist(energy, xAxis)
#plt.ylabel("Counts of Neutrons")
#plt.xlabel("Energy of Neutrons(MeV)")
#plt.title("Energy Curve of Neutrons (Cf-252)")
#plt.show()
#
#eCounts = np.array(eCounts)
#effData = np.array(effData)
#
#ratio = eCounts/effData
#ratio[np.isnan(ratio)] = 0
#ratio[np.isinf(ratio)] = 0
#
##Graph of the curve divided by the triangle
#divGraph = dividedHist(eCounts, effData, maxE, start, stop)
#plt.plot(energy, selectCounts)
#plt.title("Energy Curve Divided by Efficiency")
#plt.xlabel("Energy of Neutrons (MeV)")
#plt.ylabel("Counts/Efficiency")
#plt.rcParams.update({'font.size': 16})
#plt.show()
#
#plt.plot(selectEdges, probability, label = "Neutrons")
#plt.title("Energy Distribution of Neutrons (Cf-252)")
#plt.xlabel("Energy of Neutrons (MeV)")
#plt.ylabel("Probability of Neutron Energy")
#plt.legend()
#plt.show()
#
#maxProb = selectEdges[np.argmax(probability)]
#neutronEnergyMean = avgEnergy(selectEdges, probability)
#print("Mean of Neutron Energies: " + str(neutronEnergyMean))
#print("Highest Probability: " + str(maxProb))