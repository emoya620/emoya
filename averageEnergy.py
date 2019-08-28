#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Jul 26 11:06:28 2019

@author: Emilio Moya

Purpose: Imports a dataframe with neutron and photon data. It then creates a PDF
of the energy averages of the neutrons and returns the data to be accessed and
plotted elsewhere

University of Michigan
"""

#Imports
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import normalize as nrm
#import dnngVisualizationConstant as dnng

#A definition that can be quickly called to pull up a graph of the energy averages of neutrons in a given dataframe
def plotAvg():  
    #Sets up data frame that is used for the plot
    data = pd.read_csv('exp1' ,
                       header = None, delim_whitespace = True, nrows = 1e4,
                           names = ['History' ,
                                    'Type' ,
                                    'Channel' ,
                                    'Time' ,
                                    'Energy'])
    
    #Stores all of the neutron data seperately
    dataN = data[data.Type == 1]
    
    #Stores the count of neutrons in each history, and turns the data into an array
    MULT_N = dataN.groupby('History')["Type"].count().reset_index()
    multArray = np.array(MULT_N.Type)
    
    #Iterates through the data list and stores the neutron multiplicities
    mult = []
    for x in multArray:
        index = x
        while index > 0:
            mult += [x]
            index -= 1
    
    #Creates a multiplicity column in the dataframe, and finds the energy of the neutrons in histories where 3 reactions occured
    dataN['Multiplicity'] = mult
    energySum = (dataN[dataN.Multiplicity == 2].groupby('History')['Energy'].mean().reset_index())['Energy']
    energy1 = (dataN[dataN.Multiplicity == 2].groupby('History')['Energy'].max().reset_index())['Energy']
    energy2 = (dataN[dataN.Multiplicity == 2].groupby('History')['Energy'].min().reset_index())['Energy']
    firstC = (dataN[dataN.Multiplicity == 2].groupby('History', as_index=False).apply(lambda x: x.loc[x['Channel'].idxmax()])).Energy
    lastC = (dataN[dataN.Multiplicity == 2].groupby('History', as_index=False).apply(lambda x: x.loc[x['Channel'].idxmin()])).Energy
    
    #This stores the average energy of three neutrons in a new dataframe column
    MULT_N['EnergyAverage'] = (energySum) / 2
    
    #Stores the neutron energy averages that are greater than 0, and turns the data into array.    
    neutronAvg = MULT_N[MULT_N.EnergyAverage != 0]
    avgE = np.array(neutronAvg['EnergyAverage'])
    
    #Plots the energy average of neutrons, with a title and axis labels
    plt.hist(avgE, np.linspace(0, 25, 100))
    plt.title("Average Energy of Three Neutrons")
    plt.ylabel("Number of Neutrons")
    plt.xlabel("Energy of Neutrons (MeV)")
    plt.show()

    plt.scatter(energy1, energy2)
    plt.title("Scatterplot of Neutron Energies")
    plt.xlabel("E1")
    plt.ylabel("E2")
    plt.show()

    plt.scatter(firstC, lastC)
    plt.title("Scatterplot of Neutron Energies by Channel")
    plt.xlabel("E1")
    plt.ylabel("E2")
    plt.show()
    
    return avgE
#Plots the energy average of neutrons    
plotAvg()