package com.ko.model

import groovy.json.JsonOutput

/**
 * Created by recovery on 12/22/13.
 */
class Result {
    boolean success;
    String message;

    def String toString(){
        def jsonString = JsonOutput.toJson(this)
        return  jsonString
    }
}
