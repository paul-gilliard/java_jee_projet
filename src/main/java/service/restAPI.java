package service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import metier.Users;

@ApplicationPath("rest")
public class restAPI extends Application { 

	
	    public Set<Class<?>> getClasses() {
	        Set<Class<?>> s = new HashSet<Class<?>>();
	        s.add(userPageAPI.class);
	        return s;
	    }
	    
	    

		@Override
		public Set<Object> getSingletons() {
			 Set<Object> s = new HashSet<Object>();
		        s.add(new Users());
			return s;
		}



		public restAPI() {
			super();
			// TODO Auto-generated constructor stub
		}

}