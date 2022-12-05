import React from "react";

class AllBooks extends React.Component{
    constructor(){
        super()
        this.state = { data: [],offset: 0, perPage:6,currentPage:0,postData:[]};
        this.handlePageClick=this.handlePageClick.bind(this)
    }
    books=[]

    resp(){
        const headers=  {
            'content-type':'application/json',
            'Access-Control-Allow-Origin':'*',
            'Access-Control-Allow-Headers': ["Access-Control-Allow-Headers,Access-Control-Allow-Origin, X-Requested-With, Content-Type, Accept"]
            }
            
    }
}