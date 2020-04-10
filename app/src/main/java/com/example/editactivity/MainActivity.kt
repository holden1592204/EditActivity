@file:Suppress("DEPRECATION")

package com.example.editactivity

import android.content.Intent
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onResume() {
    super.onResume()
    PreferenceManager.getDefaultSharedPreferences(this).apply {
      val company: String? = getString("company", "")
      val postal: String? = getString("postal", "")
      val address = getString("address", "")
      val tel = getString("tel", "")
      val fax = getString("fax", "")
      val email = getString("email", "")
      val url = getString("url", "")
      val position = getString("position", "")
      val name = getString("name", "")

      companyText.text = company
      postalText.text = postal
      addressText.text = address
      telText.text = ("tel:$tel")
      faxText.text = ("fax$fax")
      emailText.text = email
      urlText.text = url
      positionText.text = position
      nameText.text = name
    }
  }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
      menuInflater.inflate(R.menu.main, menu)
      return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
      when (item?.itemId) {
        R.id.edit -> {
          //Kotlinではクラス名::class.javaでクラスのインスタンスを取得する
          val intent = Intent(this, EditActivity::class.java)
          startActivity(intent)
        }
      }
      return super.onOptionsItemSelected(item)
    }
  }
