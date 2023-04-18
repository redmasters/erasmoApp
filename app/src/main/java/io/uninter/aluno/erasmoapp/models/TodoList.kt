package io.uninter.aluno.erasmoapp.models

class TodoList {
    private val itens = mutableListOf<String>()

    fun add(item: String) {
        itens.add(item)
    }

    fun removeAt(position: Int) {
        itens.removeAt(position)
    }

    fun getItens(): List<String> {
        return itens
    }

    fun getItem(position: Int): String {
        return itens[position]
    }

    fun getItemCount(): Int {
        return itens.size
    }
}