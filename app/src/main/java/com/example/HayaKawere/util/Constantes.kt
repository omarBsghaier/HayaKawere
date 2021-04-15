package com.example.HayaKawere.util

class Constantes {
    companion object {
        private var self: Constantes? = null
        fun instance(): Constantes {
            if (self == null) {
                synchronized(Constantes::class.java) {
                    if (self == null) {
                        self = Constantes()
                    }
                }
            }
            return self!!
        }

    }


    val URl = "http://192.168.1.7:5000"
    val emailExist=""


}
