#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jul 24 10:57:30 2019

@author: Emilio Moya

Purpose: Finds the sum of two neutron energies in the same reaction, given a dataset.
It then store this info and either plots it or stores it in variables for use
elsewhere. This code selects specifically for neutrons in the same history, but
it can easily be changed to select for either neutrons 

University of Michigan
"""

#Imports
import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
import normalize as nrm
#import dnngVisualizationConstant as dnng

# Plots the energy sum of two neutron energies in one history, then returns the data of their sum and bins
def plotExp():  
    #Sets up data frame that is used for the plot
    data = pd.read_csv('exp1' ,
                       header = None, delim_whitespace = True, nrows = 1e6,
                           names = ['History' ,
                                    'Type' ,
                                    'Channel' ,
                                    'Time' ,
                                    'Energy'])
    #MULT_N stores all histories that have 2 or more neutrons
    MULT_N = data[data.Type == 1].groupby('History')["Type"].count().reset_index()
    #firstN stores the energy of the neutron that is the highest in the corresponding history
    firstN = (data[data.Type == 1].groupby('History')["Energy"].max().reset_index())['Energy']
    #firstN stores the energy of the neutron that is the lowest in the corresponding history
    lastN  = (data[data.Type == 1].groupby('History')["Energy"].min().reset_index())['Energy']
    
    #This stores the energy sum of the two neutrons in each history
    MULT_N['EnergySum'] = firstN + lastN
    
    #This stores all of the neutron energies that aren't zero, and then changes the variable to a numpy array
    neutronSum = MULT_N[MULT_N.EnergySum != 0]
    sigmaE = np.array(neutronSum['EnergySum'])
    
    #Creates the histogram, labels it, changes the font size, and plots it
#    plt.hist(sigmaE, np.linspace(0, 25, 100), alpha = 0.5)
#    plt.title("Energy Sum of Two Neutrons")
#    plt.ylabel("Neutrons")
#    plt.xlabel("Energy Sum (MeV)")
#    plt.rcParams.update({'font.size': 16})
#    plt.show()
    
    nVariance = np.var(firstN) + np.var(lastN)
    print("FirstN and LastN Variance Sum: " + str(nVariance))
    print("Null Hypothesis Variance: " + str(np.var(sigmaE)))
    
    [sumExp, expBins] = np.histogram(sigmaE, np.linspace(0, 25, 100))
    return [sumExp, expBins]
