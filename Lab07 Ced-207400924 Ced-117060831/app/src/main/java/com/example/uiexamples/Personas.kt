package com.example.uiexamples

import com.example.uiexamples.ui.Login

class Personas private constructor() {

    private var personas: ArrayList<Persona> = ArrayList<Persona>()

    init{
        addPersona(Persona("kev", "asd","Kevin", "Quesada", "kev@gmail.com", "San Ramon", 1111,1111))
        addPersona(Persona("mari", "asd", "Mariana", "Valverde", "mari@gmail.com", "San Jose", 2222,2222))
    }

    private object HOLDER {
        val INSTANCE = Personas()
    }

    companion object {
        val instance: Personas by lazy {
            HOLDER.INSTANCE
        }
    }

    fun addPersona(persona: Persona): Boolean {
        if(personas?.add(persona)){
            return true
        }
        return false
    }

    fun getPersona(nombre: String): Persona? {
        for (p: Persona in personas!!){
            if(p.name.equals(nombre)){
                return p
            }
        }
        return null;
    }

    fun getPersonas(): ArrayList<Persona>{
        return this.personas!!
    }

    fun login(user: String?, password: String?): Boolean{
        for(p: Persona in personas!!){
            if(p.user.equals(user) && p.password.equals(password)){
                return true
            }
        }
        return false
    }

    fun loginP(user: String?, password: String?): Persona?{
        for(p: Persona in personas!!){
            if(p.user.equals(user) && p.password.equals(password)){
                return p
            }
        }
        return null
    }

    fun deletePerson(position: Int){
        personas!!.removeAt(position)
    }

    fun editPerson(p: Persona){

        var aux = personas.find { a -> a.user == p.user }
        aux?.password = p.password
        aux?.name = p.name
        aux?.lastname = p.lastname
        aux?.email = p.email
        aux?.address = p.address
        aux?.cellphone = p.cellphone
        aux?.workphone = p.workphone

    }
}