package com.example.email

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Color
import android.graphics.drawable.GradientDrawable

import kotlin.math.absoluteValue

// Lớp Email chứa thông tin của từng email
data class Email(val senderName: String, val time: String, val snippet: String)

fun generateRandomColor(name: String): Int {
    val colors = listOf(
        Color.parseColor("#F44336"), // Red
        Color.parseColor("#E91E63"), // Pink
        Color.parseColor("#9C27B0"), // Purple
        Color.parseColor("#673AB7"), // Deep Purple
        Color.parseColor("#3F51B5"), // Indigo
        Color.parseColor("#2196F3"), // Blue
        Color.parseColor("#03A9F4"), // Light Blue
        Color.parseColor("#00BCD4"), // Cyan
        Color.parseColor("#009688"), // Teal
        Color.parseColor("#4CAF50"), // Green
        Color.parseColor("#8BC34A"), // Light Green
        Color.parseColor("#CDDC39"), // Lime
        Color.parseColor("#FFEB3B"), // Yellow
        Color.parseColor("#FFC107"), // Amber
        Color.parseColor("#FF9800"), // Orange
        Color.parseColor("#FF5722")  // Deep Orange
    )

    // Dựa trên mã băm của tên để chọn một màu ngẫu nhiên
    val colorIndex = name.hashCode().absoluteValue % colors.size
    return colors[colorIndex]
}
// Adapter cho RecyclerView
class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_items, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emails[position]
        holder.bind(email)
    }

    override fun getItemCount(): Int = emails.size

    // ViewHolder cho từng item
    inner class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val iconTextView: TextView = itemView.findViewById(R.id.avatar)
        private val senderNameTextView: TextView = itemView.findViewById(R.id.senderName)
        private val timeTextView: TextView = itemView.findViewById(R.id.timestamp)
        private val snippetTextView: TextView = itemView.findViewById(R.id.messagePreview)

        fun bind(email: Email) {
            // Lấy màu ngẫu nhiên dựa trên tên
            val color = generateRandomColor(email.senderName)

            // Tạo một GradientDrawable tròn với màu nền
            val drawable = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(color)
                setSize(40.dpToPx(), 40.dpToPx()) // Hàm chuyển đổi dp sang pixel
            }

            // Đặt GradientDrawable làm nền cho iconTextView
            iconTextView.background = drawable

            // Hiển thị ký tự đầu tiên của tên người gửi
            iconTextView.text = email.senderName.first().toString()
            senderNameTextView.text = email.senderName
            timeTextView.text = email.time
            snippetTextView.text = email.snippet

        }
        private fun Int.dpToPx(): Int {
            val density = itemView.context.resources.displayMetrics.density
            return (this * density).toInt()
        }
    }
}
