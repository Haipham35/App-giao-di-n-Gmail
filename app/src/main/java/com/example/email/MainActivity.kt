package com.example.email

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var emailRecyclerView: RecyclerView
    private lateinit var emailAdapter: EmailAdapter
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Thiết lập RecyclerView
        emailRecyclerView = findViewById(R.id.recyclerView)
        emailRecyclerView.layoutManager = LinearLayoutManager(this)

        // Tạo danh sách email mẫu
        val emails = listOf(
            Email("Hải Phạm", "12:34 PM", "$19 Only (First 10 spots)..."),
            Email("Android Studio", "11:22 AM", "Help make Campaign Monitor better"),
            Email("Tuto.com", "11:04 AM", "8h de formation gratuite et les nouveaux cours"),
            Email("Support", "10:26 AM", "Thông báo quan trọng: Bạn đã đăng ký thành công"),
            Email("Matt from Ionic", "9:42 AM", "The New Ionic Creator Is Here!")
        )

        // Khởi tạo adapter và gắn vào RecyclerView
        emailAdapter = EmailAdapter(emails)
        emailRecyclerView.adapter = emailAdapter

        // Xử lý sự kiện cho FloatingActionButton
        fab = findViewById(R.id.fab_add)
        fab.setOnClickListener {
            // Thêm hành động khi người dùng nhấn vào nút FAB
        }
    }
}
