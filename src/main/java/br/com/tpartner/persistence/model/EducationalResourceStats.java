/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tpartner.persistence.model;

import br.com.tpartner.persistence.crud.ResourceInteractionCRUD;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.hibernate.type.IntegerType;

/**
 *
 * @author sergio
 */
public class EducationalResourceStats {
    private final EducationalResource educationalResource;
    private Double timeSpentAverage;
    private Integer timeSpentMedian;
    private Integer maxTimeSpent;
    private Integer minTimeSpent;
    private Integer firstQuartile;
    private Integer thirdQuartile;
    private Integer interQuartileRange;
    private Integer totalInteractions;
    private List<ResourceInteraction> resourceInteractions;
    private List<ResourceInteraction> outliersInteractions;
    
    public EducationalResourceStats(EducationalResource educationalResource, 
            ResourceInteractionCRUD resourceInteractionDAO) {
        
        this.educationalResource = educationalResource;
        
        this.resourceInteractions = resourceInteractionDAO.findByEducationalResource(
            educationalResource);
        
        totalInteractions = resourceInteractions.size();
        Collections.sort(resourceInteractions, new Comparator<ResourceInteraction>(){
            public int compare(ResourceInteraction o1, ResourceInteraction o2){
               return o1.getTimeSpent() - o2.getTimeSpent();
            }
        });
        
        firstQuartile = new Double(0.25 * totalInteractions).intValue() + 1;
        thirdQuartile = new Double(0.75 * totalInteractions).intValue() + 1;
        interQuartileRange = thirdQuartile - firstQuartile;
        
        if (totalInteractions % 2 == IntegerType.ZERO) {
            timeSpentMedian = resourceInteractions.get(
                    totalInteractions/2).getTimeSpent();
            timeSpentMedian += resourceInteractions.get(
                    totalInteractions/2-1).getTimeSpent();
            timeSpentMedian /= 2;
        }
        else {
            timeSpentMedian = resourceInteractions.get(
                    totalInteractions/2).getTimeSpent();
        }
        
        minTimeSpent =resourceInteractions.get(IntegerType.ZERO).getTimeSpent();
        maxTimeSpent = resourceInteractions.get(totalInteractions-1).
                getTimeSpent();
        
        for (ResourceInteraction resourceInteraction : resourceInteractions) {
            timeSpentAverage += resourceInteraction.getTimeSpent();
        }
        timeSpentAverage /= totalInteractions;
        
        outliersInteractions = new ArrayList<ResourceInteraction>();
        for (int i = 0; i < (firstQuartile - (1.5 * interQuartileRange)); i++) {
            outliersInteractions.add(resourceInteractions.get(i));
        }
        for (int i = (totalInteractions - 1);
                i > (thirdQuartile + (1.5 * interQuartileRange)); i++) {
            outliersInteractions.add(resourceInteractions.get(i));
        }
        
    }

    public EducationalResource getEducationalResource() {
        return educationalResource;
    }
    
    public Double getTimeSpentAverage() {
        return timeSpentAverage;
    }

    public Integer getTimeSpentMedian() {
        return timeSpentMedian;
    }

    public Integer getMaxTimeSpent() {
        return maxTimeSpent;
    }

    public Integer getMinTimeSpent() {
        return minTimeSpent;
    }
    
    public List<ResourceInteraction> getResourceInteractions() {
        return resourceInteractions;
    }
    
    public Integer getFirstQuartile() {
        return firstQuartile;
    }
    
    public Integer getThirdQuartile() {
        return thirdQuartile;
    }

    public Integer getInterQuartileRange() {
        return interQuartileRange;
    }

    public List<ResourceInteraction> getOutliersInteractions() {
        return outliersInteractions;
    }

    public Integer getTotalInteractions() {
        return totalInteractions;
    }
    
}
