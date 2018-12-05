<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <xsl:apply-templates/>
        </html>
    </xsl:template>
    <xsl:template match="list">
        <head>
            <title>LISTADO DE AGENDA</title>
        </head>
        <body>
            <h1>LISTA DE AGENDA</h1>
            <table border="1">
                <tr>
                    <th>Nombre</th>
                    <th>Tlf</th>
                    <th>Dir</th>
                    <th>CP</th>
                    <th>Fechanac</th>
                    <th>Money</th>
                    <th>Cantidad</th>
                </tr>
                <xsl:apply-templates select="DatosAgenda"/>
            </table>
        </body>
    </xsl:template>
    <xsl:template match="DatosAgenda">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="nombre|tlf|dir|cp|fechanac|money|cantidad">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
</xsl:stylesheet>