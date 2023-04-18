package io.uninter.aluno.erasmoapp.controllers

import io.uninter.aluno.erasmoapp.models.TodoList

class TodoListPresenter(private val view: TodoListView) {
    private val model = TodoList()

    init {
        view.showItemList(model.getItens())
    }

    fun addItem(item: String) {
        if (item.isNotEmpty()) {
            model.add(item)
            view.showItemList(model.getItens())
        } else {
            view.showError("Digite uma tarefa")
        }
    }

    fun removeItem(index: Int) {
        model.removeAt(index)
        view.showItemList(model.getItens())
    }
}

interface TodoListView {
    fun showItemList(items: List<String>)
    fun showError(message: String)
}
