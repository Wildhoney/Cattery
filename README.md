# Cattery

> Web-based API that delivers cats straight to your browser via JSON and YAML.

![Cat Collage](http://farm6.static.flickr.com/5201/5199108732_95fca5bfc7.jpg)
<sub>Image courtesy of [Marcos Arruda](http://www.flickriver.com/photos/marcosarruda/5199108732/)</sub>

## Getting Started

All requests are routed through the index (`/`) route, and you pass additional options to the URL. By default a JSON response of 10 cat images are returned.

```
curl -i -X DELETE http://api.cattery.org/
```
