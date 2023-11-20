package com.example.formap;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Join extends AppCompatActivity {

    private Button join_finish;
    private FirebaseAuth mFirebaseAuth; // 데이터베이스 인증
    private DatabaseReference mDatabaseReference; // 실시간 데이터베이스
    private EditText formap_id, formap_name, formap_pw, formap_pwCom, formap_em;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("formap");
        formap_id = (EditText)findViewById(R.id.formap_id);
        formap_name = (EditText)findViewById(R.id.formap_name);
        formap_pw = (EditText)findViewById(R.id.formap_pw);
        formap_pwCom = (EditText) findViewById(R.id.formap_pwCom);
        formap_em = (EditText)findViewById(R.id.formap_em);
        join_finish = (Button) findViewById(R.id.join_finish);

        join_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (formap_id.getText().toString().length() == 0) {
                    Toast.makeText(Join.this, "이메일 아이디를 입력하세요", Toast.LENGTH_SHORT).show();
                    formap_id.requestFocus();
                    return;
                }
                if (formap_name.getText().toString().length() == 0) {
                    Toast.makeText(Join.this, "이름을 입력하세요", Toast.LENGTH_SHORT).show();
                    formap_name.requestFocus();
                    return;
                }
                if (formap_pw.getText().toString().length() == 0) {
                    Toast.makeText(Join.this, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                    formap_pw.requestFocus();
                    return;
                }
                if (formap_pwCom.getText().toString().length() == 0) {
                    Toast.makeText(Join.this, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                    formap_pwCom.requestFocus();
                    return;
                }
                if (formap_em.getText().toString().length() == 0) {
                    Toast.makeText(Join.this, "이메일을 입력하세요", Toast.LENGTH_SHORT).show();
                    formap_em.requestFocus();
                    return;
                }
                if (!formap_pw.getText().toString().equals(formap_pwCom.getText().toString())) {
                    Toast.makeText(Join.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    formap_pwCom.requestFocus();
                    return;
                }

                // 회원가입 처리 시작
                String strId = formap_id.getText().toString();
                String strName = formap_name.getText().toString();
                String strPw = formap_pw.getText().toString();
                String strEm = formap_em.getText().toString();

                mFirebaseAuth.createUserWithEmailAndPassword(strId, strPw).addOnCompleteListener(Join.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseUser.getUid());
                            account.setEmailId(firebaseUser.getEmail());
                            account.setName(strName);
                            account.setPassword(strPw);
                            account.setEmail(strEm);

                            // setValue: 데이터 베이스 insert
                            mDatabaseReference.child("UserAccount").child(firebaseUser.getUid()).setValue(account);
                            Intent intent = new Intent(Join.this, TasteAnalysis.class);
                            startActivity(intent);
                            Toast.makeText(Join.this, "회원가입에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Join.this, "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}