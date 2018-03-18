# Request Bin

Developers and testers often need to troubleshoot the HTTP requests that a client makes against an endpoint.
This project aims to provide a tool that allows for the creation of a "bin": a temporary url,
which a client can send HTTP requests to, so that they get recorded \ captured for logging purposes.

* create new bin: POST /bin - returns the bin id.
* record requests: /bin/{id}
* inspect requests: GET /bin/{id}/inspect - retrieve the list of requests made against this "bin."

Feel free to extend the current solution in any way that you see fit.

## Assessment Dependencies
* Please use java JDK 1.8 and Maven.
* Feel free to introduce any other dependencies you wish.
