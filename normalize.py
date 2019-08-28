#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Jul 22 13:53:10 2019

@author: Emilio Moya

Purpose: To create easily accessible methods that normalize data and create bin centers from edges

University of Michigan
"""

#Imports
import numpy as np

#Normalizes graphs to be centered  on the x-axis
def normalizeCounts(yAxis, bins):
    widths = (bins[1:] - bins[:-1])
    yAxis = np.array(yAxis)
    widths = np.array(widths)
    normalization = (yAxis * widths).sum()
    yAxis = yAxis/normalization
    return yAxis

#Finds the centers of bins given the bin edges
def edgesToCenters(edges):
    centers = (edges[:-1] + edges[1:]) /2
    return centers