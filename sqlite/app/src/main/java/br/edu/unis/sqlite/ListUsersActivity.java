package br.edu.unis.sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class ListUsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        SQLiteHelper db = SQLiteHelper.getInstance(this);
        List<User> users = db.all();

        RecyclerView rv = findViewById(R.id.list_users_rv_users);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ListUserAdapter(users));

    }

    private static class ListUserAdapter extends RecyclerView.Adapter<ListUserViewHolder> {
        private final List<User> users;

        public ListUserAdapter(List<User> users) {
            this.users = users;
        }

        @NonNull
        @Override
        public ListUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, null, false);
            return new ListUserViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ListUserViewHolder holder, int position) {
            User user = this.users.get(position);
            holder.bind(user);
        }

        @Override
        public int getItemCount() {
            return this.users.size();
        }
    }

    private static class ListUserViewHolder extends RecyclerView.ViewHolder {

        TextView txtUser;
        TextView txtId;

        public ListUserViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtUser = itemView.findViewById(R.id.user);
            this.txtId = itemView.findViewById(R.id.number);
        }

        public void bind(User user) {
            this.txtUser.setText(user.getUser());
            this.txtId.setText(""+user.getId());
        }
    }
}