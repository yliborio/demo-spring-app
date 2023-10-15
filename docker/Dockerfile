# Use the official PostgreSQL image as the base image
FROM postgres:latest

# Environment variables to set the PostgreSQL user, password, and database
ENV POSTGRES_USER=myuser
ENV POSTGRES_PASSWORD=mypassword
ENV POSTGRES_DB=mydatabase

# Copy SQL scripts to initialize the database (optional)
COPY schema.sql /docker-entrypoint-initdb.d/


# Expose PostgreSQL port
EXPOSE 5432

# Start PostgreSQL server
CMD ["postgres"]