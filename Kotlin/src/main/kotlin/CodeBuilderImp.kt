class CodeBuilderImp : CodeBuilder
{
    private var indent = 0;
    private val sb = StringBuffer()

    override fun indent()
    {
        ++indent
    }

    override fun addLine(line: String)
    {
        sb.append("    ".repeat(indent))
        sb.appendLine(line)
    }

    override fun undent()
    {
        --indent
    }

    public fun getCode() : String
    {
        return sb.toString()
    }

}