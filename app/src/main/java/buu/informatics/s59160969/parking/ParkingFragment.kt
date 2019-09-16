package buu.informatics.s59160969.parking


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160969.parking.databinding.FragmentLoginBinding
import buu.informatics.s59160969.parking.databinding.FragmentParkingBinding

/**
 * A simple [Fragment] subclass.
 */
class Data(var id : String , var model : String , var name : String  )
class ParkingFragment : Fragment() {
    private lateinit var binding: FragmentParkingBinding
    var arrayData : Array<Data> = arrayOf(Data("null","null","null"),Data("null","null","null"),Data("null","null","null"))
    var slotNumber : Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate<FragmentParkingBinding>(inflater,
            R.layout.fragment_parking,container,false)
        binding.apply{
            slot1Button.setOnClickListener{getData(0)}
            slot2Button.setOnClickListener{getData(1)}
            slot3Button.setOnClickListener{getData(2)}
            updateButton.setOnClickListener{addData(it)}
            deleteButton.setOnClickListener{deleteData()}
        }
        return binding.root
    }


    private fun deleteData(){
        arrayData.get(slotNumber).id = "null"
        arrayData.get(slotNumber).model = "null"
        arrayData.get(slotNumber).name = "null"
        if(slotNumber === 0 ){
            binding.slot1Button.text = ""
        }else  if(slotNumber === 1){
            binding.slot2Button.text  = ""
        }else if(slotNumber === 2){
            binding.slot3Button.text  = ""
        }
//        Toast.makeText(this, "ลบสำเร็จ",
//            Toast.LENGTH_SHORT).show()
        hideText()
        showEditText()

    }
    private fun showEditText(){
        binding.apply {
            idEdit.visibility  = View.VISIBLE
            modelEdit.visibility = View.VISIBLE
            nameEdit.visibility = View.VISIBLE
        }

    }

    private  fun hideEditText(){
        binding.apply {
            idEdit.text = null
            modelEdit.text = null
            nameEdit.text = null

            idEdit.visibility  = View.GONE
            modelEdit.visibility = View.GONE
            nameEdit.visibility = View.GONE
        }
    }
    private fun showText(){
        binding.apply {
            idText.visibility = View.VISIBLE
            modelText.visibility = View.VISIBLE
            nameText.visibility = View.VISIBLE
        }
    }

    private fun hideText() {
        binding.apply {
            idText.visibility = View.GONE
            modelText.visibility = View.GONE
            nameText.visibility = View.GONE
        }

    }

    private fun setData(id: String,model: String,name: String){
        arrayData.get(slotNumber).id = id
        arrayData.get(slotNumber).model = model
        arrayData.get(slotNumber).name = name
        when(slotNumber){
            0 -> binding.slot1Button.text = arrayData.get(slotNumber).id
            1 -> binding.slot2Button.text = arrayData.get(slotNumber).id
            2 -> binding.slot3Button.text = arrayData.get(slotNumber).id
        }
    }
    private fun setText(id:String , model:String , name:String){
        binding.apply {
            idText.text = "หมายเลขทะเบียนรถ "+id
            modelText.text = "รุ่นรถ " + model
            nameText.text = "ชื่อคนขับ" + name
        }
    }
    private fun getData(slotButton:Int){
        slotNumber = slotButton
        if(arrayData.get(slotNumber).id === "null"){
            hideText()
            showEditText()
        }else{
            setText(arrayData.get(slotNumber).id,arrayData.get(slotButton).model,arrayData.get(slotNumber).name)
            hideEditText()
            showText()
        }
    }
    private fun addData(view: View){

        if(binding.idEdit.visibility === View.GONE){
//            Toast.makeText(this, "มีการกำหนดค่าแล้ว",
//                Toast.LENGTH_SHORT).show()
        }else if(binding.idEdit.text.trim().length ===  0 ||
            binding.modelEdit.text.trim().length === 0 ||
            binding.nameEdit.text.trim().length === 0){
//            Toast.makeText(this, "กรุณาใส่ข้อมูลให้ครบ",
//                Toast.LENGTH_SHORT).show()
        }else{
            val id = ""+binding.idEdit.text
            val model = ""+binding.modelEdit.text
            val name = ""+binding.nameEdit.text

            setData(id , model ,name)
            setText(id , model ,name)

            hideEditText()
            showText()

           // val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            //inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }

}
