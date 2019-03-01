package com.skinnybonesarv.util;

import java.util.Map;
import java.util.function.Supplier;

public interface CSVWritable {

    Map<String, Supplier> getCSVTelemetry();

}
