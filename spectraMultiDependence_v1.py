#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jul 17 10:35:28 2019

@author: Emilio Moya

Purpose: Imports a dataframe with neutron and photon data. It then creates a PDF
of the energy differences of the neutrons and returns the data to be accessed and
plotted elsewhere

University of Michigan
"""

#Imports
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
#import dnngVisualizationConstant as dnng

# Plots the energy difference of two neutron energies in one history, then histograms them
def plotExp():  
    eMin = -25
    eMax = 25
    numBins = 100
    #Sets up data frame that is used for the plot
    data = pd.read_csv('exp1' ,
                       header = None, delim_whitespace = True, nrows = 1e5,
                           names = ['History' ,
                                    'Type' ,
                                    'Channel' ,
                                    'Time' ,
                                    'Energy'])
    
    #MULT_N stores all histories that have 2 or more neutrons
    MULT_N = data[data.Type == 1].groupby('History')["Type"].count().reset_index()
#    #firstN stores the energy of the neutron that is the highest in the corresponding history
#    firstN = (data[data.Type == 1].groupby('History')["Energy"].max().reset_index())['Energy']
#    #firstN stores the energy of the neutron that is the lowest in the corresponding history
#    lastN  = (data[data.Type == 1].groupby('History')["Energy"].min().reset_index())['Energy']
    
    #Store enery of first and last channels
    firstC = (data[data.Type == 1].groupby('History', as_index=False).apply(lambda x: x.loc[x['Channel'].idxmax()])).Energy
    lastC = (data[data.Type == 1].groupby('History', as_index=False).apply(lambda x: x.loc[x['Channel'].idxmin()])).Energy
    
    
    #This stores the energy difference of the two neutrons in each history
    MULT_N['EnergyDiff'] = firstC - lastC
    
    #This stores all of the neutron energies that aren't zero, and then changes the variable to a numpy array
    neutronDiff = MULT_N[MULT_N.Type == 2]
    deltaE = np.array(neutronDiff['EnergyDiff'])
    
    #Creates the histogram, labels it, changes the font size, and plots it
    plt.hist(deltaE, np.linspace(eMin, eMax, numBins), alpha = 0.5)
    plt.title("Energy Difference of Two Neutrons")
    plt.ylabel("Neutrons")
    plt.xlabel("Energy Difference (MeV)")
    plt.rcParams.update({'font.size': 16})
    plt.show()
    
    plt.scatter(firstC, lastC)
    plt.title("Scatterplot of Neutron Energies")
    plt.xlabel("E1")
    plt.ylabel("E2")
    plt.show()
    
    #Assigns the energy difference data and bin data to variables, and then returns them
    [diffExp, expBins] = np.histogram(deltaE, np.linspace(eMin, eMax, numBins))
    return [diffExp, expBins]

plotExp()