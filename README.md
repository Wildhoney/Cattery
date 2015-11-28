# Cattery

> Web-based API that delivers cats straight to your browser via JSON and YAML.

<img alt="Cat Collage" src="http://farm6.static.flickr.com/5201/5199108732_95fca5bfc7.jpg" width="350" />
<br />
<sub>Image courtesy of [Marcos Arruda](http://www.flickriver.com/photos/marcosarruda/5199108732/).</sub>

## Getting Started

All requests are routed through the index (`/`) route, and you pass additional options to the URL. By default a JSON response of 10 cat images are returned.

```{r, engine='bash', count_lines}
curl -i -X GET http://api.cattery.org/
```

## Limiting

Providing the `limit` parameter will limit the amount of cats returned &mdash; when you specify <kbd>1</kbd> then a non-array will be returned that will contain the one entry.

```{r, engine='bash', count_lines}
curl -i -X GET http://api.cattery.org/?limit=1
curl -i -X GET http://api.cattery.org/?limit=25
curl -i -X GET http://api.cattery.org/?limit=100
```

**Note:** You can specify a maximum of <kbd>100</kbd>.

## Type

By supplying the `type` parameter you can specify how the data is returned. By default the `json` parameter is used &ndash; however you can return `xml`, `jsonp` (with a function to invoke) and `image` (which will automatically limit to <kbd>1</kbd>).

```{r, engine='bash', count_lines}
curl -i -X GET http://api.cattery.org/?type=xml
curl -i -X GET http://api.cattery.org/?type=image&limit=1
curl -i -X GET http://api.cattery.org/?type=jsonp(callbackFn)
```

## Specific

All cats returned have an ID associated with them in the `id` field. You can therefore request exact cat pictures using this ID by providing the `id` parameter.

```{r, engine='bash', count_lines}
curl -i -X GET http://api.cattery.org/?id=66ffa74c972848ab1a123895c6ebdaca
```

