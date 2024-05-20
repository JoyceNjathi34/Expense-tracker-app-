package com.joyce.expensetrackerapp.model

class Expense {
    var name:String=""
    var quantity:String=""
    var category:String=""
    var price:String=""
    var date:String=""
    var id:String=""

    constructor(name:String,quantity:String,category:String,price:String,date:String,id:String){
        this.name=name
        this.quantity=quantity
        this.category=category
        this.price=price
        this.date=date
        this.id=id
    }
    constructor()
}