#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Jul 24 10:53:26 2019

@author: Emilio Moya

University of Michigan
"""

import matplotlib.pyplot as plt
import spectraMultiDependence_v2 as spmd
import probDistributionOfToFSum as pdfs
import normalize as nrm

[ctsExperiment, expBins] = spmd.plotExp()
[ctsSimulation, simBins] = pdfs.plotSim()

normExp = nrm.normalizeCounts(ctsExperiment, expBins)
normSim = nrm.normalizeCounts(ctsSimulation, simBins)

centersExp = nrm.edgesToCenters(expBins)
centersSim = nrm.edgesToCenters(simBins)

plt.plot(centersExp, normExp, label = "Experiment")
plt.plot(centersSim, normSim, label = "Null Hypothesis")
plt.ylabel("Normalized Counts")
plt.xlabel("Energy Sum Between Two Neutrons (MeV)")
plt.legend()
plt.show()