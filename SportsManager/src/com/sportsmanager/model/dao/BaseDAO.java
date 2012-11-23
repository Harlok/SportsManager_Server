package com.sportsmanager.model.dao;

import java.lang.reflect.Method;

public class BaseDAO 
{
	
	
	public Object asDTO() 
	{
		@SuppressWarnings("rawtypes")
		Class targetClass;
		Object target = null;
		int i;
		
		String getterName;
		Method getter;
		Method setter;
		Object value;
		
		try 
		{
			String targetClassName = this.getClass().getName();
			targetClassName = targetClassName.substring(0,targetClassName.length()-3);
			targetClassName = targetClassName.replace(".dao.", ".dto.");
			targetClass = Class.forName(targetClassName);
			target = targetClass.newInstance();
			
		    Method methods[] = targetClass.getMethods();
		    for (i = 0; i < methods.length; i++) 
		    {
		        if ((methods[i].getName().startsWith("set")) && (methods[i].getModifiers() == 1) && (methods[i].getReturnType() != java.util.Collection.class))
		        {
		        	setter = methods[i];
		        	if (setter.getParameterTypes()[0] == Boolean.TYPE)
		        	{
		        		getterName = "is" + methods[i].getName().substring(3);
		        	}
		        	else
		        	{
		        		getterName = "get" + methods[i].getName().substring(3);
		        	}
		        	
		        	try
		        	{
			        	getter = this.getClass().getMethod(getterName);
			        	if (getter.getReturnType() != java.util.Collection.class)
			        	{
				        	//System.out.println("getter " + methods[i].getName() + " returns " + getter.getReturnType());
				        	//setter = methods[i];
				        	
				        	value = getter.invoke(this);
				        	setter.invoke(target, value);
			        	}
		        	}
		        	catch (Exception e1)
		        	{
		        		//System.out.println("Skipping copy of " + setter.getName());
		        	}
		        }
		    }
		}
		catch (Exception e2)
		{
			System.out.println("Exception: " + e2);
		}
		
		return target;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void copyDTO(Object source) 
	{
		
		Class sourceClass;
		Class targetClass;
		int i;
		String setterName;
		//String getterName;
		Method setter;
		Method getter;
		Object value;
		
		try 
		{
			sourceClass = source.getClass();
			targetClass = this.getClass();
			
		    Method sourceMethods[] = sourceClass.getMethods();
		    //Method targetMethods[] = this.getClass().getMethods();
		    
		    for (i = 0; i < sourceMethods.length; i++) 
		    {
		        if ((sourceMethods[i].getName().startsWith("get") || sourceMethods[i].getName().startsWith("is")) && (sourceMethods[i].getModifiers() == 1) && (sourceMethods[i].getReturnType() != java.util.Collection.class))
		        {
		        	getter = sourceMethods[i];
		        	//getterName = getter.getName();
		        	setterName = "set" + getter.getName().substring(3);
		        	
		        	if (getter.getReturnType() != java.util.Collection.class)
		        	{
			        	value = getter.invoke(source);
			        	try
			        	{
			        		setter = targetClass.getMethod(setterName, getter.getReturnType());
			        		setter.invoke(this, value);
			        	}
			        	catch (Exception e1)
			        	{
			        		System.out.println("Skipping copy of " + setterName);
			        	}
			        	
			        	//setter.invoke(this, value);
		        	}
		        }
		    }
		}
		catch (Exception e)
		{
			System.out.println("Exception: " + e);
		}
		
		
	}
}
