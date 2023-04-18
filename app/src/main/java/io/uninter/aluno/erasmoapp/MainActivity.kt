package io.uninter.aluno.erasmoapp

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private lateinit var listView: ListView
    private lateinit var todoItens: ArrayList<String>
    private lateinit var listAdapter: ArrayAdapter<String>
    private lateinit var novaTarefaText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.todo_list)
       novaTarefaText = findViewById(R.id.novaTarefa)

        todoItens = ArrayList()
        listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todoItens)

        listView.adapter = listAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener {
                _, _, position, _ ->
            val item = todoItens[position]
            Toast.makeText(this@MainActivity, item, Toast.LENGTH_SHORT).show()
        }

        val botaoAdicionar: Button = findViewById(R.id.botaoAdicionar)
        botaoAdicionar.setOnClickListener{
            val novaTarefa: String = novaTarefaText.text.toString().trim()
            if (novaTarefa.isNotEmpty()) {
                todoItens.add(novaTarefa)
                novaTarefaText.setText("")
                listAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this@MainActivity, "Digite uma tarefa", Toast.LENGTH_SHORT).show()
            }
        }

        listView.onItemClickListener = AdapterView.OnItemClickListener {
                _, _, position, _ ->
            todoItens.removeAt(position)
            listAdapter.notifyDataSetChanged()
        }

        listAdapter.notifyDataSetChanged()

    }
}