package com.ko.model

import com.google.code.morphia.annotations.Id
import com.google.code.morphia.annotations.Transient
import com.google.code.morphia.query.UpdateOperations
import org.bson.types.ObjectId

/**
 * Created by recovery on 12/22/13.
 */
class BaseEntity<T> {
    @Id
    ObjectId _id

    @Transient
    String identifier

    @Transient
    protected  static Connector _connector = new Connector()

    def UpdateOperations getUpdateOps(Class cls){
        return _connector.getDatastore().createUpdateOperations(cls)
    }

    def Result save(){
        try {
            _connector.getDatastore().save(this)
            return  new Result(success: true)
        }catch(e){
            return new Result(success: false, message: e.getMessage())
        }
    }

    def static <T> T findByExample(T example){
        try {
            def customer = _connector.getDatastore().queryByExample(example).get()
            return  customer
        }catch (e){
            println(e.getMessage())
            return  null
        }
    }
}
