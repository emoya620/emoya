#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Jul 19 15:04:28 2019

@author: Emilio Moya

Purpose: To easily access the functions of the normalize, spectraMultiDependence, and
probabilityDistributionOfToF programs. This cript assigns the data to variables, normalizes the data,
finds the bin centers of the data, and finally plots the data.

University of Michigan
"""
#Imports
#import pandas as pd
#import numpy as np
import matplotlib.pyplot as plt
import spectraMultiDependence_v1 as smd
import probabilityDistributionOfToF as pdf
import normalize as nrm

#Experimental center and bin data
[ctsExperiment, expBins] = smd.plotExp()
#Simulation center and bin data
[ctsSimulation, simBins] = pdf.plotSim()

#Normalized experimental data
normExp = nrm.normalizeCounts(ctsExperiment, expBins)
#Normalized simulation data
normSim = nrm.normalizeCounts(ctsSimulation, simBins)

#Experimental bin centers
centersExp = nrm.edgesToCenters(expBins)
#Simulation bin centers 
centersSim = nrm.edgesToCenters(simBins)

#Plots both the simulation and experimental graphs
plt.plot(centersExp, normExp, label = "Experiment")
plt.plot(centersSim, normSim, label = "Null Hypothesis")
plt.ylabel("Normalized Counts")
plt.xlabel("Energy Difference Between Two Neutrons (MeV)")
plt.legend()
plt.show()