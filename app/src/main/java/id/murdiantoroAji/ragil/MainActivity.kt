package id.murdiantoroAji.ragil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.button2)
        btn.setOnClickListener{cek()}
    }

    private fun currencyConvert(num: Double): String {
        return NumberFormat.getCurrencyInstance().format(num)
    }

    private fun cek(){

        // Get All result layout element
        val biaya_layout: LinearLayout = findViewById(R.id.biaya)
        val bunga_layout: LinearLayout = findViewById(R.id.bunga)
        val total_bersih_layout: LinearLayout = findViewById(R.id.total_bersih)
        val total_pinjam_layout: LinearLayout = findViewById(R.id.total_pinjam)

        // Get Input Value
        val input_pinjaman: TextInputEditText = findViewById(R.id.pinjaman_edit_text)
        val tenor: TextInputEditText = findViewById(R.id.tenor_edit_text)
        var pinjaman_value = input_pinjaman.text.toString().toDoubleOrNull()
        var tenor_value = tenor.text.toString().toDoubleOrNull()

        // Calculate Loan Simulation
        var biaya = pinjaman_value?.times(0.05)
        var bunga = pinjaman_value?.times(0.0375)
        var total_bersih = pinjaman_value?.minus(biaya!!)
        var total_pinjam = tenor_value?.let { bunga?.times(it)?.let { pinjaman_value?.plus(it) } }

        // Get Result Element
        val bi_res: TextView = findViewById(R.id.biaya_result)
        val sb_res: TextView = findViewById(R.id.bunga_result)
        val pb_res: TextView = findViewById(R.id.total_bersih_result)
        val tp_res: TextView = findViewById(R.id.total_pinjam_result)

        // put to text
        bi_res.text = currencyConvert(biaya!!)
        sb_res.text = currencyConvert(bunga!!)
        pb_res.text = currencyConvert(total_bersih!!)
        tp_res.text = currencyConvert(total_pinjam!!)

        // Make is Visible
        biaya_layout.visibility = View.VISIBLE
        bunga_layout.visibility = View.VISIBLE
        total_bersih_layout.visibility = View.VISIBLE
        total_pinjam_layout.visibility = View.VISIBLE
    }

}