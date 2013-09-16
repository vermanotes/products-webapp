# product-list-webapp #

This is a sample web application for purposes of learning and practicing 
techniques. The intent is to develop a web application using the following
technologies:

* Spring
* Spring Security for login
* Hibernate with H2
* ThymeLeaf for HTML Rendering
* Twitter Bootstrap for some basic styling

## Features in the project ##

* User can login (accounts are: admin/password and user/password) ... the spring security stuff is pretty basic
so you won't learn anything new here.
* User is able to view a list of products.
* I used content negotiation to represent xml/json and html views at the same time
..- This does not work out well, because adding extra dynamic content to your html view only (which seems to be
reasonable to expect since html has links to other things) requires you to have mvc interceptors. Unless you have
a convention of doing this regularly, this might be problematic (few controllers, many interceptors).
* The only code worth extending upon is the following:
..- A GenericDao for JPA, this is better done in Spring Data JPA, but it does give you a starting point if you
do not want to use Spring Data JPA for some reason.
..- A GenericListElementWrapper for Jaxb and Jackson. The JSON version of the products api is pretty straight forward,
but the complexity is in getting the XML and JSON versions to return similar data structures. One caveat of using this
is that the XMLElement will always be named "list", so there are probably better ways around this.






