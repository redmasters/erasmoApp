package io.uninter.aluno.erasmoapp

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import io.uninter.aluno.erasmoapp.controllers.TodoListPresenter
import io.uninter.aluno.erasmoapp.controllers.TodoListView

class MainActivity : ComponentActivity(), TodoListView {
    private lateinit var listView: ListView
    private lateinit var listAdapter: ArrayAdapter<String>
    private lateinit var novaTarefaText: EditText
    private lateinit var presenter: TodoListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.todo_list)
        novaTarefaText = findViewById(R.id.novaTarefa)

        listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf())
        listView.adapter = listAdapter

        presenter = TodoListPresenter(this)

        val botaoAdicionar: Button = findViewById(R.id.botaoAdicionar)
        botaoAdicionar.setOnClickListener {
            val novaTarefa: String = novaTarefaText.text.toString().trim()
            presenter.addItem(novaTarefa)
            novaTarefaText.setText("")
        }

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            presenter.removeItem(position)
        }
    }

    override fun showItemList(items: List<String>) {
        listAdapter.clear()
        listAdapter.addAll(items)
        listAdapter.notifyDataSetChanged()
    }

    override fun showError(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}