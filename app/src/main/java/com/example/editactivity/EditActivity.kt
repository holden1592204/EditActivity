@file:Suppress("DEPRECATION")

package com.example.editactivity

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit2.*

//名刺データ編集
class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) { //既に保存された情報があればonCreate()メソッドで取得して各項目をEditTextに　編集する
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit2)

        PreferenceManager.getDefaultSharedPreferences(this).apply {
            //getDefaultSharedPreferences()メソッドでSharedPreferencesオブジェクトを取得
            val company: String? = getString("company", "")
            val postal: String? = getString("postal", "")
            val address = getString("address", "")
            val tel = getString("tel", "")
            val fax = getString("fax", "")
            val email = getString("email", "")
            val url = getString("url", "")
            val position = getString("position", "")
            val name = getString("name", "")

            companyEdit.setText(company)
            postalEdit.setText(postal)
            addressEdit.setText(address)
            telEdit.setText(tel)
            faxEdit.setText(fax)
            emailEdit.setText(email)
            urlEdit.setText(url)
            positionEdit.setText(position)
            nameEdit.setText(name)

            saveBtn.setOnClickListener {
                saveData()  //共有プリファレンスにデータを保存
                finish()  //saveBtnが実行された時アクティビティを終了する
            }

            cancelBtn.setOnClickListener {
                finish()  //cancelBtnが押された時実行され、アクティビティを終了する
            }
          }
        }


        private fun saveData() {
            val pref = PreferenceManager.getDefaultSharedPreferences(this)
            val editor = pref.edit()
            editor.putString("company", companyEdit.text.toString())
                .putString("postal", postalEdit.text.toString())
                .putString("address", addressEdit.text.toString())
                .putString("tel", telEdit.text.toString())
                .putString("fax", faxEdit.text.toString())
                .putString("email", emailEdit.text.toString())
                .putString("url", urlEdit.text.toString())
                .putString("position", positionEdit.text.toString())
                .putString("name", nameEdit.text.toString())
                .apply()

        }
    }

