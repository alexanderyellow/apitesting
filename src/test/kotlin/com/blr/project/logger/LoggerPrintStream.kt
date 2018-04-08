package com.blr.project.logger

import org.slf4j.Logger
import java.io.IOException
import java.io.OutputStream
import java.io.PrintStream

/**
 * A wrapper class which takes a logger as constructor argument and offers a PrintStream whose flush
 * method writes the written content to the supplied logger (debug level).
 * <p>
 * Usage:<br>
 * initializing in @BeforeClass of the unit test:
 * <pre>
 *          LoggerPrintStream loggerPrintStream = new LoggerPrintStream( myLog );
 *          RestAssured.config = RestAssured.config().logConfig(
 *                                 new LogConfig( loggerPrintStream.getPrintStream(), true ) );
 * </pre>
 * will redirect all log outputs of a ValidatableResponse to the supplied logger:
 * <pre>
 *             resp.then().log().all( true );
 * </pre>
 */
class LoggerPrintStream {

    private val PROPERTY = System.getProperty("line.separator")

    private var myLogger: Logger
    private var myPrintStream: PrintStream? = null

    constructor(myLogger: Logger): super() {
        this.myLogger = myLogger
    }

    /**
     * @return printStream
     */
    fun getPrintStream(): PrintStream? {

        if (myPrintStream == null) {
            val output = object : OutputStream() {
                private var myStringBuilder = StringBuilder()

                @Throws(IOException::class)
                override fun write(b: Int) {
                    this.myStringBuilder.append(b.toChar())
                }

                /**
                 * @see java.io.OutputStream.flush
                 */
                override fun flush() {
                    val msg = this.myStringBuilder.toString()
                    if (!(msg == "" || msg == PROPERTY || msg == "\n")) {
                        myLogger.trace(msg)
                    }
                    myStringBuilder = StringBuilder()
                }
            }

            myPrintStream = PrintStream(output, true)  // true: autoflush must be set!
        }

        return myPrintStream
    }

    fun requestPrintStream(): PrintStream? {
        //println("requestPrintStream!!!!")
        return getPrintStream()
    }

    fun responsePrintStream(): PrintStream? {
        //println("responsePrintStream!!!!")
        return getPrintStream()
    }

}