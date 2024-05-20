package com.joyce.expensetrackerapp.model

class Transaction{
    var amount:String=""
    var type:String=""
    var date:String=""
    var id:String=""

    constructor(amount:String,type:String,date:String,id:String){
        this.amount=amount
        this.type=type
        this.date=date
        this.id=id
    }

    constructor()
}