package com.example.user.gunasofinal;

import android.support.v7.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
//    Button signup,login,forum;
//    EditText email,password;
//    public String mail,pass;
//    Comment comment;
//    public String userid;
//    String TAG="TAG";
//    //String appVersion = "v1";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        signup=(Button)findViewById(R.id.btn_register);
//        login=(Button)findViewById(R.id.btn_login);
//        email=(EditText)findViewById(R.id.txt_email);
//        password=(EditText)findViewById(R.id.txt_password);
//        forum=(Button)findViewById(R.id.btn_forum);
//
//        comment=new Comment();
//        comment.setAuthorEmail("rumi@gmail.com");
//        comment.setMessage("Hello world");
//
//
//
//
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Backendless.initApp(getApplicationContext(),"F4C26AE7-9CA0-8CB8-FF49-D66D9F1C0D00", "9D8E4C70-E734-CAA5-FFFD-B69BAE068400");
//
//                loginUserAsync();
////                passMessage();
////                subscribeMessage();
//            }
//        });
//
//       signup.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               Intent intent=new Intent(LoginActivity.this,SignUp.class);
//               startActivity(intent);
//           }
//       });
//
//        forum.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(LoginActivity.this,ForumActivity.class);
//                startActivity(intent);
//            }
//        });
//
//    }
//
////    private void passMessage()
////    {
////        AsyncCallback<MessageStatus> callback1=new AsyncCallback<MessageStatus>() {
////            @Override
////            public void handleResponse(MessageStatus response) {
////                Log.e("TAG", "handleResponse:messgae " +response);
////
////
////            }
////
////            @Override
////            public void handleFault(BackendlessFault fault) {
////
////            }
////        };
////        Backendless.Messaging.publish( comment, callback1);
////        //Log.e("TAG", "handleResponse: "+status.getStatus() );
////
////       }
////
////    private void subscribeMessage(){
////        Backendless.Messaging.subscribe(
////                new AsyncCallback<List<Message>>()
////                {
////                    public void handleResponse( List<Message> response )
////                    {
////                        for( Message message : response )
////                        {
////                            String publisherId = message.getPublisherId();
////                            Object data = message.getData();
////                            Toast.makeText(LoginActivity.this, ""+data.toString(), Toast.LENGTH_SHORT).show();
////                        }
////                    }
////                    public void handleFault( BackendlessFault fault )
////                    {
////                        Toast.makeText( LoginActivity.this, fault.getMessage(), Toast.LENGTH_SHORT ).show();}
////                },
////
////                new AsyncCallback<Subscription>()
////                {
////                    public void handleResponse( Subscription response )
////                    {
////                        Subscription subscription = response;
////                    }
////                    public void handleFault( BackendlessFault fault )
////                    {
////                        Toast.makeText( LoginActivity.this, fault.getMessage(), Toast.LENGTH_SHORT ).show();
////                    }
////                }
////        );
////    }
//
//
//
//    private  void loginUserAsync()
//    {
//        mail=email.getText().toString();
//        pass=password.getText().toString();
//        Log.e("TAG", "loginUser: "+mail+pass );
//        AsyncCallback<BackendlessUser> callback = new AsyncCallback<BackendlessUser>()
//        {
//            @Override
//            public void handleResponse( BackendlessUser loggedInUser )
//            {
//                System.out.println( "User has been logged in - " + loggedInUser.getObjectId() );
//                userid=loggedInUser.getObjectId();
//                Log.e(TAG, "userid1is: "+userid);
//                Log.e(TAG, "handleResponse: "+loggedInUser.getUserId() );
//                if (userid!=null){
//                    Intent intent=new Intent(LoginActivity.this, ComplainActivity.class);
//                    intent.putExtra("rumi",userid);
//                    Log.e(TAG, "userid:2 "+userid );
//                    startActivity(intent);
//                }
//            }
//
//            @Override
//            public void handleFault( BackendlessFault backendlessFault )
//            {
//                System.out.println( "Server reported an error - " + backendlessFault.getMessage() );
//            }
//        };
//
//        Backendless.UserService.login( mail, pass , callback );
//    }


}
