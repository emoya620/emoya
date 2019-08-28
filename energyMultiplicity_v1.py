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


def plotAvg():  
    #Sets up data frame that is used for the plot
    data = pd.read_csv('exp1' ,
                       header = None, delim_whitespace = True, nrows = 1e7,
                           names = ['History' ,
                                    'Type' ,
                                    'Channel' ,
                                    'Time' ,
                                    'Energy'])
    
    dataN = data[data.Type == 1]
    
    MULT_N = dataN.groupby('History')["Type"].count().reset_index()
    
    multArray = np.array(MULT_N.Type)
    
    mult = []
    for x in multArray:
        index = x
        while index > 0:
            mult += [x]
            index -= 1

    dataN['Multiplicity'] = mult
    meanN = []
    
    for multiplicity in range(1,4):
        energyMult = (dataN[dataN.Multiplicity == multiplicity]).Energy
        plt.hist(energyMult, np.linspace(0, 25, 100), alpha = 0.5, normed = 1, label = str(multiplicity) + " Neutrons")
        meanN += [energyMult.mean()]
        
    plt.title("Average Energy of Neutrons")
    plt.xlabel("Energy of Neutrons (MeV)")
    plt.ylabel("Counts")
    plt.legend()
    plt.show()
    
    plt.plot(range(1,4), meanN)
    plt.show()
    
    return energyMult
    
plotAvg()