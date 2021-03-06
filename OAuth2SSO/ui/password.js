import React from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import Login from './components/Login.jsx';
import injectTapEventPlugin from 'react-tap-event-plugin';
import $ from 'jquery';

injectTapEventPlugin();
class App extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      content:''
    }
  }

  componentDidMount(){
    // alert('did mount');
  }

  componentWillMount(){
    let url = window.location.search,
        code = url.slice(0,5),
        codeURL = "http://192.168.1.244:9999/OAuth2-SSO/oauth/token",
        codeCompare = url.substring(6,url.length);
          let payload = {
                          "grant_type": "password",
                          "username": "user1",
                          "password": 123456
                        }
              $.ajax({
                      url: codeURL,
                      type: 'POST',
                      data: payload,
                      beforeSend: function(xhr){xhr.setRequestHeader('Authorization', 'Basic eGViaWFfeGtlOnhlYmlhX3hrZV9zZWNyZXQ=')},
                      contentType: 'application/x-www-form-urlencoded',
                      success: function(data){
                        console.log('data',data);
                      },
                      error: function(data,textStatus) {
                        alert(textStatus)
                        alert(JSON.stringify(data)); //or whatever
                      }
                    });
    // if(code !== "?code"){
    //   window.location="http://192.168.1.244:9999/uaa/oauth/authorize?client_id=acme&response_type=code&redirect_uri=http://192.168.2.246:8080";
    // }else{
    //   // alert(codeCompare)

    //
    //       }
        }

   render() {
      return (
         <div className = "mainWrapper">
            <MuiThemeProvider>
               <Login/>
             </MuiThemeProvider>
         </div>
      );
   }


}



export default App;
