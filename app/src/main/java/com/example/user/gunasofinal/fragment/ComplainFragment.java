package com.example.user.gunasofinal.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.user.gunasofinal.ComplainActivity;
import com.example.user.gunasofinal.ForumActivity;
import com.example.user.gunasofinal.R;
import com.example.user.gunasofinal.SignUp;
import com.example.user.gunasofinal.model.Comment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComplainFragment extends Fragment {

    View mView;
    Button signup,login,forum;
    EditText email,password;
    public String mail,pass;
    Comment comment;
    public String userid;
    String TAG="TAG";
    BackendlessUser userLogIn;

    public ComplainFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.activity_login, container, false);
        return mView;

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signup=(Button)view.findViewById(R.id.btn_register);
        login=(Button)view.findViewById(R.id.btn_login);
        email=(EditText)view.findViewById(R.id.txt_email);
        password=(EditText)view.findViewById(R.id.txt_password);
        forum=(Button)view.findViewById(R.id.btn_forum);

        comment=new Comment();
        comment.setAuthorEmail("rumi@gmail.com");
        comment.setMessage("Hello world");




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             /*   Backendless.initApp(getContext(),"F4C26AE7-9CA0-8CB8-FF49-D66D9F1C0D00", "9D8E4C70-E734-CAA5-FFFD-B69BAE068400");

                final Order order = new Order();

                OrderItem orderItem1 = new OrderItem();
                orderItem1.setName( "Printer" );
                orderItem1.setQuantity( 1 );
                orderItem1.setPrice( 99 );

                OrderItem orderItem2 = new OrderItem();
                orderItem2.setName( "Paper" );
                orderItem2.setQuantity( 10 );
                orderItem2.setPrice( 19 );

                order.addOrderItem( orderItem1 );
                order.addOrderItem( orderItem2 );
                order.setOrderName( "Office Supplies" );
                order.setOrderNumber( 1 );

                Thread t=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Backendless.Data.of( Order.class ).save( order );
                        System.out.println( "Order has been saved" );
                    }
                });
                t.start();*/



                loginUserAsync();
//                passMessage();
//                subscribeMessage();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SignUp.class);
                startActivity(intent);
            }
        });

        forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ForumActivity.class);
                startActivity(intent);
            }
        });

    }
    private  void loginUserAsync()
    {
        mail=email.getText().toString();
        pass=password.getText().toString();
        Log.e("TAG", "loginUser: "+mail+pass );
        AsyncCallback<BackendlessUser> callback = new AsyncCallback<BackendlessUser>()
        {
            @Override
            public void handleResponse( BackendlessUser loggedInUser )
            {
                userLogIn=loggedInUser;
                System.out.println( "User has been logged in - " + loggedInUser.getObjectId() );
                userid=loggedInUser.getObjectId();
                Log.e(TAG, "handleResponse: user is :  "+loggedInUser.toString() );
                Log.e(TAG, "userid1is: "+userid);
                Log.e(TAG, "handleResponse: "+loggedInUser.getUserId() );
                if (userid!=null){
                    Intent intent=new Intent(getActivity(), ComplainActivity.class);
                    intent.putExtra("rumi",userid);
                    Log.e(TAG, "userid:2 "+userid );
                    startActivity(intent);
                }
            }

            @Override
            public void handleFault( BackendlessFault backendlessFault )
            {
                System.out.println( "Server reported an error - " + backendlessFault.getMessage() );
            }
        };

        Backendless.UserService.login( mail, pass , callback );



    }



    }


