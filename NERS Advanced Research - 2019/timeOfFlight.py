#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Jul 11 14:12:33 2019

@author: Emilio Moya

Purpose: Plots the neutron ToF given some imported data.

University of Michigan
"""

#Imports
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

#Variables
meC = 0.511
mnC = 0.939
mpC = 0.938
C = 30

#Finds energy given an input of time
def findEnergy(time):
    V = distance / time
    E = (.5) * mnC * (V / C)
    
#Imports a data file, and stores it in a dataframe    
data = pd.read_csv('neutronToF/expfiles/exp1' ,
                   nrows = 1e6, header = None, delim_whitespace = True,
                       names = ['History' , 
                                'Type' ,
                                'Channel' ,
                                'Time' ,
                                'Energy'])

    
    
    
    
    
#PLots either neutron or photon time of flight    
#plt.hist(data[data.Type == 1].Time, np.linspace(0, 100, 100))
plt.hist(data[data.Type == 2].Time, np.linspace(0, 30, 100))
plt.xlabel("Time (ns)")
plt.ylabel("Photon Counts")
plt.title("Photon Time of Flight")
plt.show()

##Plots the energy spectrum of either neutrons or photons
#plt.hist(data[data.Type == 1].Energy, np.linspace(0, 25, 100), alpha = 0.5)
#plt.hist(data[data.Type == 2].Energy, np.linspace(0, 25, 100), alpha = 0.5)
#plt.xlabel("Time (ns)")
#plt.ylabel("")
#plt.title("")
#plt.show()


