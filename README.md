# Spring Data with multiple Mongo Databases

This is a working example using Spring Boot 2.0.4 (spring-boot-starter-data-mongodb) which connects to two mongo databases at the same time.  Domain objects are saved to different databases depending on which package the Repository is defined in.  Out of all the approaches I reviewed this appears to be the least configuration required.

Credit goes to this blog post: http://www.javaoptimum.com/multiple-mongodb-connections-spring-boot/ for the majority of the work.

One minor change was made as the MongoProperties.createMongoClient() method appears to have been removed since that blog post.
