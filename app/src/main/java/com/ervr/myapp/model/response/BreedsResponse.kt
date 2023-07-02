package com.ervr.myapp.model.response

data class BreedsResponse(
    val message: Map<String, List<String>>,
    val status: String
)