package com.iafedoseev.chameleon

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform