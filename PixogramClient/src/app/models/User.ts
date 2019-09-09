
export class User{
    public id:number;
    constructor(
            public firstname:String,
            public lastname:String,
            public username:String,
            public password:String,
            public email:String
        ) {
    }  
}