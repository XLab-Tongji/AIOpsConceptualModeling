Sampling: 

  Type: class

  mySampling: Sampling is a mechanism to control the noise and overhead introduced by OpenTelemetry by reducing the number of samples of traces collected and sent to the backend.

Sampler: 

  Type: class

  mySampler: Sampler interface allows users to create custom samplers which will return a sampling SamplingResult based on information that is typically available just before the Span was created.

  ShouldSample: Returns the sampling Decision for a Span to be created.

  RequiredArguments: Context with parent span, TraceId of the span to be created, name of the span to be created, SpanKind of the Span to be created, initial set of Attributes of the Span to be created, Collection of links that will be associated with the Span to be created.

  ReturnValue: A sampling Decision, a set of span Attributes that will also be added to the Span, a Tracestate that will be associated with the Span through the new SpanContext.

  GetDescription: Returns the sampler name or short description with the configuration.

BuiltInSamplers: 

  Type: class

  AlwaysOn: Returns RECORD_AND_SAMPLE always. Description MUST be AlwaysOnSampler.

  AlwaysOff: Returns DROP always. Description MUST be AlwaysOffSampler.

  TraceIdRatioBased: The TraceIdRatioBased MUST ignore the parent SampledFlag. Description MUST be TraceIdRatioBased {0.0001000}.

TracerProvider: 

  Type: class

  TracerCreation: The TracerProvider MAY provide methods to update the configuration.

  ShutDown: This method provides a way for provider to do any cleanup required.

AdditionalSpanInterfaces: 

  Type: class

  ReadableSpan: A function receiving this as argument MUST be able to access all information that was added to the span.

  Read/WriteSpan: A function receiving this as argument must have access to both the full span API as defined in the API-level definition for span's interface and additionally must be able to retrieve all information that was added to the span (as with readable span).  

SpanProcessor: 

  Type: class

  OnStart: OnStart is called when a span is started. This method is called synchronously on the thread that started the span, therefore it should not block or throw exceptions. Parameters: Span and ParentContext. Returns: Void.

  OnEnd: `OnEnd` is called after a span is ended (i.e., the end timestamp is already set). This method MUST be called synchronously within the Span.End() API, therefore it should not block or throw an exception. Parameters: Span. Returns: Void.

  Shutdown(): Shuts down the processor. Called when SDK is shut down. This is an opportunity for processor to do any cleanup required.

  ForceFlush(): Exports all spans that have not yet been exported to the configured Exporter.

BuiltInProcessor: 

  Type: class

  SimpleProcessor: This is an implementation of SpanProcessor which passes finished spans and passes the export-friendly span data representation to the configured SpanExporter, as soon as they are finished.

  ConfigurableParameters: exporter - the exporter where the spans are pushed.

  BatchingProcessor: This is an implementation of the SpanProcessor which create batches of finished spans and passes the export-friendly span data representations to the configured SpanExporter.

  ConfigurableParameters: Exporter - the exporter where the spans are pushed. MaxQueueSize - the maximum queue size. After the size is reached spans are dropped. The default value is 2048. ScheduledDelayMillis - the delay interval in milliseconds between two consecutive exports. The default value is 5000. ExportTimeoutMillis - how long the export can run before it is cancelled. The default value is 30000. MaxExportBatchSize - the maximum batch size of every export. It must be smaller or equal to maxQueueSize. The default value is 512.

SpanExporter: 

  Type: class

  mySpanExporter: Span Exporter defines the interface that protocol-specific exporters must implement so that they can be plugged into OpenTelemetry SDK and support sending of telemetry data.

TermsDefinedInResourceSDKSpecification: 

  Type: class

  Resources: A set of key-values with unique keys describing the process.

  InstrumentationLibrary: The name and version associated with a package of instrumentation.

SignificantDataTypesUsedInTheModelArchitecture: 

  Aggregator: Aggregates one or more measurements in a useful way.

  AggregatorSnapshot: Copy of an synchronous instrument aggregator taken during collection.

  AggregatorSelector: Chooses which Aggregator to assign to a metric instrument.

  Accumulation: Consists of Instrument, Label Set, Resource, and Aggregator snapshot, output by Accumulator.

  Aggregation: The result of aggregating one or more events by a specific aggregator, output by Processor.

  AggregationKind: Describes the kind of read API the Aggregation supports (e.g., Sum).

  ExportKind: One of Delta, Cumulative, or Pass-Through.

  ExportKindSelector: Chooses which ExportKind to use for a metric instrument.

  ExportRecord: Consists of Instrument, Label Set, Resource, Timestamp(s), and Aggregation.

  ExportRecordSet: A set of export records.

DataflowDiagram: 

  Type: class

  myDataflowDiagram: From an external perspective, the Metrics SDK implements the Meter and MeterProvider interfaces described in the Metrics API. From an internal perspective, the Metrics SDK encapsulates an export pipeline for metric data consisting of four major components.