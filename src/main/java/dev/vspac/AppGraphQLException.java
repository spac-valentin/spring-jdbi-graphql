package dev.vspac;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import java.util.List;
import java.util.Map;

public class AppGraphQLException
    extends RuntimeException implements GraphQLError {
  private static final long serialVersionUID = 4474098539088570792L;
  private Map<String, Object> extensions = null;

  public AppGraphQLException(String message) { super(message); }
  public AppGraphQLException(
      String message, Map<String, Object> extensions) {
    this(message);
    this.extensions = extensions;
  }

  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }

  @Override
  public ErrorType getErrorType() {
    return null;
  }

  @Override
  public List<Object> getPath() {
    return null;
  }

  @Override
  public Map<String, Object> toSpecification() {
    return null;
  }

  @Override
  public Map<String, Object> getExtensions() {
    return extensions;
  }
}