package com.example.testelistcheckbox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testelistcheckbox.adapters.AbstractRecyclerAdapter
import com.example.testelistcheckbox.adapters.ItemAdapter
import com.example.testelistcheckbox.databinding.FragmentFirstBinding
import com.example.testelistcheckbox.itemlist.ItemList
import com.example.testelistcheckbox.itemlist.SeedingService

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private lateinit var itemAdapter: ItemAdapter


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var seddingList = SeedingService()

        var lista: MutableList<ItemList> = seddingList.retornaListaItens().toMutableList()
        itemAdapter = ItemAdapter(
            requireActivity(),
            lista,
            onClick = object : AbstractRecyclerAdapter.OnClick<ItemList> {
                override fun onClick(view: View?, item: ItemList, position: Int) {
                    item.isExpanded  =  item.isExpanded.not()
                    if(item.isExpanded) {
                        if (!item.itensList.isNullOrEmpty()) {
                            item.itensList!!.forEach { itemList ->
                                itemList.childOf = item.name
                                itemList.isExpanded = true
                                itemAdapter.itens.addAll(item.itensList!!.filter { it -> it.isExpanded && !it.childOf.isNullOrEmpty() })
                                itemAdapter.notifyDataSetChanged()
                            }
                        }
                    }else {
                        item.itensList!!.forEach { itemList ->
                            itemList.childOf = ""
                            itemList.isExpanded = false
                            itemAdapter.itens.removeAll(item.itensList!!.filter { !it.isExpanded && it.childOf.isNullOrEmpty() })
                            itemAdapter.notifyDataSetChanged()
                        }
                    }
                }
            })
        binding.FirstFragment.adapter = itemAdapter
        var llm = LinearLayoutManager(requireActivity())
        llm.orientation = LinearLayoutManager.VERTICAL
        binding.FirstFragment.layoutManager = llm
        itemAdapter.notifyDataSetChanged()
    }

    private fun reformaLista(mutableList: MutableList<ItemList>): MutableList<ItemList> {
        return mutableListOf()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}