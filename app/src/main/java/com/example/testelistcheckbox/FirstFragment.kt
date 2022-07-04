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
import com.example.testelistcheckbox.itemlist.ProdutoFamilia
import com.example.testelistcheckbox.itemlist.SeedingService

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private var viewModel = FirstViewModel()

    private lateinit var itemAdapter: ItemAdapter


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        _binding!!.lifecycleOwner = viewLifecycleOwner
        _binding!!.viewModel = viewModel

        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var seddingList = SeedingService()

        var lista: MutableList<ProdutoFamilia> = seddingList.retornaListaItens().toMutableList()
        itemAdapter = ItemAdapter(
            requireActivity(),
            lista,
            onClick = object : AbstractRecyclerAdapter.OnClick<ProdutoFamilia> {
                override fun onClick(view: View?, item: ProdutoFamilia, position: Int) {
                    requireActivity().runOnUiThread {
                        if (item.isExpanded) {
                            item.isExpanded = item.isExpanded.not()
                            if (!item.itensList.isNullOrEmpty()) {
                                item.itensList!!.forEach { produto ->
                                    produto.isExpanded = true
                                }
                                itemAdapter.itens.addAll(item.itensList!!.filter { it.isExpanded })
                            }
                        } else {
                            item.isExpanded = item.isExpanded.not()
                            if (!item.itensList.isNullOrEmpty()) {
                                item.itensList!!.forEach { produto ->
                                    produto.isExpanded = false
                                }
                                itemAdapter.itens.removeAll(item.itensList!!.filter { !it.isExpanded })
                            }
                        }
                        itemAdapter.notifyDataSetChanged()
                    }
                }
            })
        binding.FirstFragment.adapter = itemAdapter
        val llm = LinearLayoutManager(requireActivity())
        llm.orientation = LinearLayoutManager.VERTICAL
        binding.FirstFragment.layoutManager = llm
        itemAdapter.notifyDataSetChanged()
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}