package com.hubspot.jackson.datatype.protobuf;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleSerializers;

/**
 * Module to add support for reading and writing Protobufs
 *
 * Register with Jackson via {@link com.fasterxml.jackson.databind.ObjectMapper#registerModule}
 */
public class ProtobufModule extends Module {

  @Override
  public String getModuleName() {
    return "ProtobufModule";
  }

  @Override
  public Version version() {
    return ModuleVersion.instance.version();
  }

  @Override
  public void setupModule(SetupContext context) {
    SimpleSerializers serializers = new SimpleSerializers();
    serializers.addSerializer(new ProtobufSerializer());

    context.addSerializers(serializers);
    context.addDeserializers(new ProtobufDeserializerFactory());
  }
}